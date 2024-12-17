const createButton = () => {
	const buttonContainer = document.createElement('div');
	buttonContainer.className = 'button-container';

	const button = document.createElement('button');
	button.innerText = 'Play Round';

	button.addEventListener('click', playRound);
	buttonContainer.appendChild(button);
	return buttonContainer;
}