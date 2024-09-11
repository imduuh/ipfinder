function ipDto(country, city) {
    this.country = country;
    this.city = city;
}

function enviarDados() {
    const ip = document.getElementById('inputData').value;
    const url = `http://localhost:8080/ip/info/${ip}`;

    fetch(url, { method: 'GET' })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao fazer a requisição');
        }
        return response.json();
    })
    .then(data => {
        const dto = new ipDto(data.country, data.city);

        document.getElementById('country').innerText = dto.country;
        document.getElementById('city').innerText = dto.city;

        document.getElementById('responseMessage').style.display = 'block';
    })
    .catch(error => {
        console.error('Erro:', error);
        document.getElementById('responseMessage').innerText = 'Erro ao enviar dados!';
        document.getElementById('responseMessage').style.display = 'block';
    });
}