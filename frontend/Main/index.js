const API_URL = "http://localhost:8080/helphub";

const createButton = () => {
	const buttonContainer = document.createElement('div');
	buttonContainer.className = 'button-container';

	const button = document.createElement('button');
	button.innerText = 'Play Round';

	button.addEventListener('click', playRound);
	buttonContainer.appendChild(button);
	return buttonContainer;
}

window.onload = function () {

	const container = document.querySelector('.container-app');

	const game = document.createElement('div');
	game.className = 'game';

	const p1Div = createPlayerContainer(1);
	const p2Div = createPlayerContainer(2);

	game.appendChild(p1Div);
	game.appendChild(p2Div);

	const buttonContainer = createButton();

	container.appendChild(game);
	container.appendChild(buttonContainer);
}