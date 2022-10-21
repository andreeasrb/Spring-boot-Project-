const textInput = document.querySelector("#username");

const passwordInput = document.querySelector("#password");

const loginButton = document.querySelector("#btnsubmit");

const formElem = document.querySelector('.login');

const errorLabel = document.querySelector("#error");

const user = document.querySelector('#name');

loginButton.addEventListener("click", () => {
    const login = "http://localhost:8080/app/users/login";
    const profilepage = "http://localhost:8080/app/materiiStud/{studentName}";
    let username = textInput.value;

    /*    function createCookie(name, pass) {
            today = new Date();
            var expire = new Date();
            expire.setTime(today.getTime() + 3600000*24*15);

            document.cookie = "name= " + username+";path=/" + ";expires="+expire.toUTCString();
            document.cookie = "password=" + encodeURI(parola)+";path=/" + ";expires="+expire.toUTCString();
            //debugger;
        }*/

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

    fetch(profilepage, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then((responseObj) => {
        if (responseObj.status === 200) {
        }
        return responseObj.json();
    })
        .catch((error) => {
            console.log(JSON.stringify("Error"), error);
        })
});

