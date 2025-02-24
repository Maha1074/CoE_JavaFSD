let index = 0;

function showSlides() {
    const slides = document.querySelector('.slides');
    const totalSlides = document.querySelectorAll('.slide').length;
    const slideWidth = document.querySelector('.slide').offsetWidth + 20; // Including margin

    if (index >= totalSlides - 1) {
        index = 0;
    } else if (index < 0) {
        index = totalSlides - 1;
    }

    slides.style.transform = `translateX(${-index * slideWidth}px)`;
}

function nextSlide() {
    index++;
    showSlides();
}

function prevSlide() {
    index--;
    showSlides();
}
