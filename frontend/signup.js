document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('form#signupForm');
    const nameInput = document.getElementById('name');
    const emailInput = document.getElementById('email');
    const password1 = document.getElementById('password');
    const password2 = document.getElementById('confirmPassword');
    const signupBtn = document.getElementById('sign-up-button');

    function setError(input) {
        input.classList.add('input-error');
    }

    function clearError(input) {
        input.classList.remove('input-error');
    }

    function validateEmail(email) {
        const pattern = /^[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/i;
        return pattern.test(email);
    }

    // Toggle password visibility for each eye icon
    document.querySelectorAll('.eye-icon').forEach(icon => {
        icon.addEventListener('click', () => {
            const container = icon.closest('.password-box') || icon.closest('.input-wrap');
            const input = container ? container.querySelector('input') : null;
            if (!input) return;
            const type = input.getAttribute('type') === 'password' ? 'text' : 'password';
            input.setAttribute('type', type);
            icon.classList.toggle('fa-eye-slash');
        });
    });

    form.addEventListener('submit', (e) => {
        e.preventDefault();

        let valid = true;
        [nameInput, emailInput, password1, password2].forEach(clearError);

        if (!nameInput.value || nameInput.value.trim().length < 3) {
            setError(nameInput);
            valid = false;
        }

        if (!validateEmail(emailInput.value.trim())) {
            setError(emailInput);
            valid = false;
        }

        if (password1.value.length < 6) {
            setError(password1);
            valid = false;
        }

        if (password1.value !== password2.value) {
            setError(password1);
            setError(password2);
            valid = false;
        }

        if (!valid) {
            const firstError = document.querySelector('.input-error');
            if (firstError) firstError.focus();
            return;
        }

        signupBtn.disabled = true;
        signupBtn.textContent = 'Signing up...';

        setTimeout(() => {
            window.location.href = 'hero.html';
        }, 800);
    });
});
