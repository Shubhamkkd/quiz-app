// Import required modules
const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');
const bodyParser = require('body-parser');

// Create express app
const app = express();
const port = 3000;

// Enable CORS for cross-origin requests
app.use(cors());

// Middleware to parse JSON
app.use(bodyParser.json());

// Create MySQL connection
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'quiz_app'
});

// Connect to MySQL
db.connect((err) => {
  if (err) throw err;
  console.log('Connected to MySQL Database');
});

// API to get all quiz questions and answers
app.get('/api/questions', (req, res) => {
  const query = 'SELECT * FROM questions';
  
  db.query(query, (err, questions) => {
    if (err) throw err;
    
    // For each question, retrieve its answers
    const questionsWithAnswers = questions.map((question) => {
      return new Promise((resolve, reject) => {
        db.query('SELECT * FROM answers WHERE question_id = ?', [question.id], (err, answers) => {
          if (err) reject(err);
          resolve({
            ...question,
            answers: answers
          });
        });
      });
    });

    Promise.all(questionsWithAnswers).then((questions) => {
      res.json(questions);
    }).catch((err) => {
      res.status(500).json({ message: 'Error fetching data' });
    });
  });
});

// Start the server
app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});
