// Sidebar click navigation
document.querySelectorAll(".menu-item").forEach(item => {
    item.addEventListener("click", function () {
        const page = this.getAttribute("data-page");
        window.location.href = page; // Open new page
    });
});
