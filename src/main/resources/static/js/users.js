function init() {
    requireAuth();
    loadUsers();
}

async function loadUsers() {
    const token = localStorage.getItem("token");

    const res = await fetch("/api/users", {
        headers: {
            "Authorization": "Bearer " + token
        }
    });

    if (res.status === 403) {
        alert("Chỉ có admin mới xem được danh sách");
        return;
    }

    const users = await res.json();
    const tbody = document.getElementById("userTbody");
    tbody.innerHTML = "";

    users.forEach((u, index) => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${index + 1}</td>
            <td>${u.username}</td>
            <td>${u.roleName}</td>
            <td>${u.active ? "Hoạt động" : "Dừng hoạt động"}</td>
        `;
        tbody.appendChild(tr);
    });
}

