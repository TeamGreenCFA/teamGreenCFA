window.onload = function () {
	const swiper = new Swiper('.slider-wrapper', {
        spaceBetween: 15, // Espaçamento entre os cards
        loop: true,
        grabCursor: true,
        spaceBetween: 30,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
            dynamicBullets: true
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        pagination: {
            el: '.swiper-pagination', // Paginação
            clickable: true
          },
        breakpoints: {
            0: {
                slidesPerView: 1
            },
            768: {
                slidesPerView: 2
            },
            1024: {
                slidesPerView: 3
            }
        }
    });

  }
  