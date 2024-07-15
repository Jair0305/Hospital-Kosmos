document.getElementById('consultarCitasForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const tipoConsulta = document.getElementById('tipoConsulta').value;
    const fecha = document.getElementById('fecha').value;
    const doctorId = document.getElementById('doctorId').value;
    const consultorioId = document.getElementById('consultorioId').value;
    let url = '';

    if (tipoConsulta === 'fecha' && fecha) {
        url = `http://localhost:8080/citas/fecha?fecha=${encodeURIComponent(fecha)}`;
    } else if (tipoConsulta === 'doctor' && doctorId && fecha) {
        url = `http://localhost:8080/citas/doctor/${doctorId}?fecha=${encodeURIComponent(fecha)}`;
    } else if (tipoConsulta === 'consultorio' && consultorioId && fecha) {
        url = `http://localhost:8080/citas/consultorio/${consultorioId}?fecha=${encodeURIComponent(fecha)}`;
    } else {
        alert('Por favor complete los campos necesarios para la consulta.');
        return;
    }

    fetch(url)
        .then(response => response.json())
        .then(data => {
            const resultadosConsulta = document.getElementById('resultadosConsulta');
            resultadosConsulta.innerHTML = ''; // Clear previous results

            if (data.length === 0) {
                resultadosConsulta.innerHTML = '<p>No se encontraron citas.</p>';
            } else {
                const listaCitas = document.createElement('ul');

                data.forEach(cita => {
                    const listItem = document.createElement('li');
                    listItem.textContent = `Cita ID: ${cita.id}, Paciente: ${cita.nombreDelPaciente}, Horario: ${cita.horario}, Doctor ID: ${cita.doctor.id}, Consultorio ID: ${cita.consultorio.id}`;
                    listaCitas.appendChild(listItem);
                });

                resultadosConsulta.appendChild(listaCitas);
            }
        })
        .catch(error => {
            alert('Error al consultar las citas: ' + error.message);
            console.error(error);
        });
});
