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
  
    // Carregar dados ao inicializar a página
    resetList();
  
    // Evento para os botões de filtro
    const filterButtons = document.querySelectorAll('.filter-btn');
    filterButtons.forEach(button => {
      button.addEventListener('click', function () {
        const service = button.getAttribute('data-service');
        filterCards(service); // Filtra os cards com o serviço selecionado
      });
    });
  }
  
  let bensData = []; // Armazenando os dados dos bens
  
  function resetList() {
    const API_URL = "http://localhost:8080/finalProject/api/ben";  // Sua URL da API
    fetch(API_URL)
      .then((response) => response.json())
      .then((bens) => {
        bensData = bens; // Armazena os dados
        populateTable(bens); // Exibe todos os bens inicialmente
      })
      .catch((error) => {
        console.error("Erro ao carregar dados:", error);
      });
  }
  
  function populateTable(bens) {
    const cards = document.getElementById("cards");
    cards.innerHTML = ""; // Limpa os cards antes de adicionar novos
    bens.forEach((ben) => {
      const cardHTML = `
        <div class="card-item swiper-slide" data-ben-id="${ben.id}" data-service="${ben.services.toLowerCase()}">
          <img src="servicesImages/shopping-cart.jpg" alt="User Image" class="user-image">
          <h3 class="service">${ben.services}</h3>
          <p class="user-name">${ben.firstName + " " + ben.lastName}</p>
          <p class="description">${ben.description}</p>
          <button class="message-button">Message</button>
        </div>
      `;
      cards.innerHTML += cardHTML;
    });
  
    // Delegação de eventos para o botão "Message"
    cards.addEventListener('click', function (event) {
      if (event.target && event.target.classList.contains('message-button')) {
        const cardItem = event.target.closest('.card-item');
        const benId = cardItem.dataset.benId; // Obtém o ID do "ben" do card
  
        const ben = bens.find(b => b.id == benId);
  
        if (ben) {
          alert(`${ben.firstName + " " + ben.lastName}:\n\nPhone Number: ${ben.phone}\nAddress: ${ben.address}\nDescription: ${ben.description}`);
        }
      }
    });
  }
  
  // Função de filtro dos cards
  function filterCards(service) {
    const filteredBens = bensData.filter(ben => ben.services.toLowerCase() === service.toLowerCase());
    populateTable(filteredBens); // Atualiza a lista com os bens filtrados
  }
  