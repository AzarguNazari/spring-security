<#-- @ftlvariable name="user" type="custom.security.domain.User" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.css" type="text/css">
    <meta charset="utf-8">
    <title>User details</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>User details</h1>

<p>E-mail: ${user.email}</p>

<p>Role: ${user.role}</p>
</body>
</html>