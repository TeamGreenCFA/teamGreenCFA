window.onload = function () {

    // Inicializa o Swiper
    const swiper = new Swiper('.slider-wrapper', {
        spaceBetween: 15, // Espaçamento entre os cards
        loop: true,
        grabCursor: true,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
            dynamicBullets: true
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
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

    // Chama a função para carregar os dados após a inicialização do Swiper
    resetList();
}

function resetList() {
    
    const API_URL = "http://localhost:8080/finalProject/api/vol";
    fetch(API_URL)
        .then((response) => response.json())
        .then((vols) => {
            console.log(1234);
            populateTable(vols);
        })
        .catch((error) => {
            console.error("Erro ao carregar dados:", error);
        });
}

function populateTable(vols) {
    const cards = document.getElementById("cards");
    cards.innerHTML = ""; // Limpa os cards antes de adicionar novos
    vols.forEach((vol) => {
        // Cria o HTML para cada item da lista de voluntários e adiciona o `data-vol-id` com o `vol.id`
        const cardHTML = `
            <div class="card-item swiper-slide" data-vol-id="${vol.id}">
                <img src="servicesImages/shopping-cart.jpg" alt="User Image" class="user-image">
                <h3 class="service">${vol.services}</h3>
                <p class="user-name">${vol.firstName + " " + vol.lastName}</p>
                <p class="description">${vol.descriptions}</p>
                <button class="message-button">Message</button>
            </div>
        `;
        cards.innerHTML += cardHTML; // Adiciona o card ao container
    });

    // Delegação de eventos para o botão "Message"
    cards.addEventListener('click', function(event) {
        // Verifica se o botão clicado é o botão "Message"
        if (event.target && event.target.classList.contains('message-button')) {
            const cardItem = event.target.closest('.card-item'); // Encontrar o item de card que foi clicado
            const volId = cardItem.dataset.volId; // Obtém o ID do "vol" do card

            // Encontre o voluntário correspondente a partir do ID
            const vol = vols.find(v => v.id == volId);

            if (vol) {
                // Exibe o alerta com as informações do voluntário
                alert(`${vol.firstName + " " + vol.lastName}:\n\nPhone Number: ${vol.phone}\nAddress: ${vol.address}\nEmail: ${vol.email}`);
            }
        }
    });
}
