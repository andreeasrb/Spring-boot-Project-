let profilepage = "http://localhost:8080/app/materiiStud/";
const user = document.querySelector('#name');
const materie = document.querySelector('#materie');

profilepage += document.cookie.split('name=')[1];

/*fetch(profilepage, {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    }
}) .then((responseObj) => {
    if (responseObj.status === 200) {
        responseObj.json();
    }
})
    .then((json) => {
        user.innerHTML += document.cookie.split('name=')[1];
        alert(json);
    })
    .catch((error) => {
        console.log(JSON.stringify("Error"), error);
    })
*/

fetch(profilepage)
    .then((response) => response.json())
    .then((data) => {
        user.innerHTML += document.cookie.split('name=')[1];
        materie.innerHTML += data;
    });