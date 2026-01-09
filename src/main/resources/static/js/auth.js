async function login(){
    const username = document.getElementById("username").value
    const password = document.getElementById("password").value
    const res = await fetch("/api/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    });
    if (!res.ok) {
        alert("Đăng nhập thất bại");
        return;
    }
    const data = await res.json();
    localStorage.setItem("token", data.token)
    localStorage.setItem("username", data.username)
    localStorage.setItem("role", data.role)
    window.location.href="/users.html"
}