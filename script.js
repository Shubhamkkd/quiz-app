document.addEventListener("DOMContentLoaded", function () {
    const quizContainer = document.getElementById('quiz');
    const submitButton = document.getElementById('submit-btn');
    const resultContainer = document.getElementById('result');

    // Fetch quiz data from the Node.js server
    fetch('http://localhost:3000/api/questions')
        .then(response => response.json())
        .then(data => {
            let quizHTML = '';
            data.forEach((question, index) => {
                quizHTML += `<div class="question">
                                <h3>${question.question_text}</h3>`;
                question.answers.forEach(answer => {
                    quizHTML += `<label>
                                    <input type="radio" name="question${index}" value="${answer.id}">
                                    ${answer.answer_text}
                                  </label><br>`;
                });
                quizHTML += '</div>';
            });
            quizContainer.innerHTML = quizHTML;
        });

    // Handle quiz submission
    submitButton.addEventListener('click', function () {
        let score = 0;
        const allQuestions = document.querySelectorAll('.question');

        allQuestions.forEach((question, index) => {
            const selectedAnswer = question.querySelector('input[type="radio"]:checked');
            if (selectedAnswer) {
                const answerId = selectedAnswer.value;
                // Check if the answer is correct
                fetch(`http://localhost:3000/api/check-answer/${answerId}`)
                    .then(response => response.json())
                    .then(data => {
                        if (data.is_correct) {
                            score++;
                        }
                    });
            }
        });

        // Display the result
        resultContainer.innerHTML = `Your score: ${score}`;
    });
});
