<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="custom.security.domain.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.css" type="text/css">
    <meta charset="utf-8">
    <title>Home page</title>
</head>
<body>

<section class="hero">
  <div class="hero-body">
    <div class="container">
      <h1 class="title">
        Home Page
      </h1>
      <h2 class="subtitle">

        <nav role="navigation">
            <ul>
            <#if !currentUser??>
                <li><a href="/login" class="button is-primary m-2">Log in</a></li>
            </#if>
            <#if currentUser??>
                <li>
                    <form action="/logout" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="button button-danger">Log out</button>
                    </form>
                </li>
                <li><a href="/user/${currentUser.id}" class="button is-primary m-2">View myself</a></li>
            </#if>
            <#if currentUser?? && currentUser.role == "ADMIN">
                <li><a href="/user/create" class="button is-primary m-2">Create a new user</a></li>
                <li><a href="/users" class="button is-primary m-2">View all users</a></li>
            </#if>
            </ul>
        </nav>
      </h2>
    </div>
  </div>
</section>
</body>
</html>