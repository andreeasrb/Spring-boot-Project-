const textInput = document.querySelector("#username");

const passwordInput = document.querySelector("#password");

const loginButton = document.querySelector("#btnsubmit");

const formElem = document.querySelector('.login');

const errorLabel = document.querySelector("#error");

const user = document.querySelector('#name');

let profilepage = "http://localhost:8080/app/materiiStud/";


loginButton && loginButton.addEventListener("click", () => {
    const login = "http://localhost:8080/app/users/login";
    let username = textInput.value;

    const formData = new FormData(formElem);
    const data = Object.fromEntries(formData);

    fetch(login, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then((responseObj) => {
        if (responseObj.status === 302) {
            window.location.replace("/profile.html");
            document.cookie = "name=" + username;
        } else {
            responseObj.status = 403;
            errorLabel.style = "color: red";
        }
        return responseObj.json();
    })
        .catch((error) => {
            console.log(JSON.stringify("Error"), error);
        });

});

