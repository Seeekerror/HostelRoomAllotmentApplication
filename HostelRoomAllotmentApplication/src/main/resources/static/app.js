// REGISTER API

const registerForm = document.getElementById("registerForm");

if(registerForm){

    registerForm.addEventListener("submit", async function (e){

        e.preventDefault();



        const data = {

            name: document.getElementById("name").value,

            email: document.getElementById("email").value,

            password: document.getElementById("password").value,

            gender: document.getElementById("gender").value,

            year: parseInt(
                document.getElementById("year").value
            ),

            course: document.getElementById("course").value
        };



        const response = await fetch(
            "http://localhost:8080/auth/register",
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(data)
            }
        );



        const result = await response.text();

        alert(result);

        window.location.href = "login.html";
    });
}

// LOGIN API

const loginForm = document.getElementById("loginForm");

if(loginForm){

    loginForm.addEventListener("submit", async function (e){

        e.preventDefault();



        const data = {

            email: document.getElementById("loginEmail").value,

            password: document.getElementById("loginPassword").value
        };



        const response = await fetch(
            "http://localhost:8080/auth/login",
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(data)
            }
        );



        const result = await response.text();

        alert(result);



        if(result === "Login Successful"){

            window.location.href = "dashboard.html";
        }
    });
}





// ROOM ALLOCATION API

const allocationForm =
    document.getElementById("allocationForm");

if(allocationForm){

    allocationForm.addEventListener(
        "submit",
        async function (e){

        e.preventDefault();



        const data = {

            studentId: parseInt(
                document.getElementById("studentId").value
            ),

            preferredFloor: parseInt(
                document.getElementById("preferredFloor").value
            ),

            preferredRoomType:
                document.getElementById(
                    "preferredRoomType"
                ).value,

            preferredCapacity: parseInt(
                document.getElementById(
                    "preferredCapacity"
                ).value
            )
        };



        const response = await fetch(
            "http://localhost:8080/allocation/allocate",
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(data)
            }
        );



        const result = await response.text();

        alert(result);
    });
}





// FETCH ALL ROOMS

async function loadRooms(){

    const roomTableBody =
        document.getElementById("roomTableBody");



    if(roomTableBody){

        const response = await fetch(
            "http://localhost:8080/rooms"
        );



        const rooms = await response.json();



        rooms.forEach(room => {

            const row = `

                <tr>

                    <td>${room.id}</td>

                    <td>${room.roomNumber}</td>

                    <td>${room.floorNumber}</td>

                    <td>${room.roomType}</td>

                    <td>${room.capacity}</td>

                    <td>${room.occupiedBeds}</td>

                    <td>${room.gender}</td>

                    <td>${room.allowedYear}</td>

                    <td>${room.allowedCourse}</td>

                </tr>

            `;



            roomTableBody.innerHTML += row;
        });
    }
}



// AUTO LOAD ROOM TABLE

loadRooms();