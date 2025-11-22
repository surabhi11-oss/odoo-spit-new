// HERO.JS (for index.html Dashboard only)

// Sidebar active highlight
(function () {
    const current = location.pathname.split("/").pop() || "index.html";

    document.querySelectorAll(".nav-item").forEach(item => {
        const href = item.getAttribute("href");
        if (href === current) {
            item.classList.add("active");
        } else {
            item.classList.remove("active");
        }
    });
})();

// Top-bar search behavior (optional)
document.querySelector("input[placeholder='Search SKU...']")?.addEventListener("input", e => {
    console.log("Searching:", e.target.value);
});

// Example button actions (if needed later)
document.querySelectorAll(".btn").forEach(btn => {
    btn.addEventListener("click", () => {
        console.log("Button clicked:", btn.innerText);
    });
});
