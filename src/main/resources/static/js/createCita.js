document.getElementById('createCitaForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const horario = document.getElementById('horario').value;
    const nombreDelPaciente = document.getElementById('nombreDelPaciente').value;
    const consultorioId = document.getElementById('consultorioId').value;
    const doctorId = document.getElementById('doctorId').value;

    if (!horario || !nombreDelPaciente || !consultorioId || !doctorId) {
        alert('Todos los campos son obligatorios.');
        return;
    }

    const citaData = {
        horario: horario,
        nombreDelPaciente: nombreDelPaciente,
        consultorio: { id: consultorioId },
        doctor: { id: doctorId }
    };

    fetch('http://localhost:8080/citas', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(citaData)
    })
        .then(response => {
            if (!response.ok) {
                return response.json().then(errorData => { throw new Error(errorData.message) });
            }
            return response.json();
        })
        .then(data => {
            alert('Cita creada con éxito');
            console.log(data);
        })
        .catch(error => {
            alert('Error al crear la cita: ' + error.message);
            console.error(error);
        });
});
