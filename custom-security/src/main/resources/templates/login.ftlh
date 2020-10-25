<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.css" type="text/css">
    <meta charset="utf-8">
    <title>Log in</title>
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
        Login
      </h1>
      <h2 class="subtitle">

        <div class="container mt-6">
          <form role="form" action="/login" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


              <div class="field">
                <label class="label" for="email">Email address</label>
                <div class="control">
                  <input class="input" type="email" name="email" id="email" required autofocus/>
                </div>
              </div>

              <div class="field">
                <label class="label" for="password">Password</label>
                <div class="control">
                  <input class="input" type="password" name="password" id="password" required/>
                </div>
              </div>

              <div class="field">
                <div class="control">
                    <label class="checkbox">
                        <input type="checkbox"> Remember Me
                    </label>
                </div>
              </div>

              <div class="field is-grouped">
                <div class="control">
                  <button class="button is-link" type="submit">Login</button>
                </div>
              </div>
          </form>

            <#if error.isPresent()>
                <div class="notification is-danger mt-4 p-4">
                  <button class="delete"></button>
                  The email or password you have entered is invalid, try again.
                </div>
            </#if>

        </div>

      </h2>
    </div>
  </div>
</section>

</body>
</html>