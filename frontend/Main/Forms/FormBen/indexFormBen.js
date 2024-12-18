const buttonAdd = document.getElementById("add-btn");
buttonAdd.addEventListener("click", function () {
    addUserPost();
})

async function addUserPost() {
    const firstName = document.getElementById("inputFirstName").value;
    const lastName = document.getElementById("inputLastName").value;
    const email = document.getElementById("inputAge").value;
    const phone = document.getElementById("inputPhone").value;
    const age = document.getElementById("inputEmail").value;
    const address = document.getElementById("inputAddress").value;
    const service = document.getElementById("inputService").value;
    const disabled = document.getElementById("inputDescription").value; 
    const elder = document.getElementById("inputDisabled").value; 
    const description = document.getElementById("inputElder").value;

    let data = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        phone: phone,
        age: age,
        address: address,
        service: service,
        elder: elder,
        disabled: disabled,
        description: description
    }

    const url = "http://localhost:8080/finalProject/api/customer";
    const response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });
    add some redirection


}