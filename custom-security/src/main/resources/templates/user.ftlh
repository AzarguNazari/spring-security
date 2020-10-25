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
        <li><a href="/" class="button is-primary m-2">Home</a></li>
    </ul>
</nav>

    <section class="hero">
        <div class="hero-body">
            <div class="container">
              <h1 class="title">
                User Details
              </h1>
             <div class="card">
                <div class="card-image" style="width:100px; height: 100px">
                    <figure class="image is-4by3">
                        <img src="https://image.flaticon.com/icons/png/512/149/149071.png" alt="User">
                    </figure>
                </div>
             <div class="card-content">
                <div class="media">
                    <div class="media-content">
                        <p class="title is-4">Email: ${user.email}</p>
                        <p class="title is-4">Role: ${user.role}</p>
                    </div>
                </div>
            </div>
            </div>
        </div>
      </div>
    </section>

</body>
</html>