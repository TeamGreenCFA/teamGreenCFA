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
    
    const API_URL = "http://localhost:8080/finalProject/api/ben";
    fetch(API_URL)
        .then((response) => response.json())
        .then((bens) => {
            console.log(1234);
            populateTable(bens);
        })
        .catch((error) => {
            console.error("Erro ao carregar dados:", error);
        });
}

function populateTable(bens) {
    const cards = document.getElementById("cards");
    cards.innerHTML = ""; // Limpa os cards antes de adicionar novos
    bens.forEach((ben) => {
        // Cria o HTML para cada item da lista de bens e adiciona o `data-ben-id` com o `ben.id`
        const cardHTML = `
            <div class="card-item swiper-slide" data-ben-id="${ben.id}">
                <img src="servicesImages/shopping-cart.jpg" alt="User Image" class="user-image">
                <h3 class="service">${ben.services}</h3>
                <p class="user-name">${ben.firstName + " " + ben.lastName}</p>
                <p class="description">${ben.description}</p>
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
            const benId = cardItem.dataset.benId; // Obtém o ID do "ben" do card

            // Encontre o bem correspondente a partir do ID
            const ben = bens.find(b => b.id == benId);

            if (ben) {
                // Exibe o alerta com as informações do bem
                alert(`${ben.firstName + " " + ben.lastName}:\n\nPhone Number: ${ben.phone}\nAddress: ${ben.address}\nDescription: ${ben.description}`);
            }
        }
    });
}
