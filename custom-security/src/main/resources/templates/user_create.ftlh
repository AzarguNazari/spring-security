<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="custom.security.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.css" type="text/css">
    <meta charset="utf-8">
    <title>Create a new user</title>
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
        Create a new user
      </h1>
    </div>
    <div class="container mt-6">
      <form role="form" name="form" action="" method="post">
          <div class="field">
            <label class="label" for="email">Email</label>
            <div class="control">
              <input class="input" type="email" name="email" id="email" value="${form.email}" required autofocus>
            </div>
          </div>

          <div class="field">
            <label class="label" for="password">Password</label>
            <div class="control">
              <input class="input" type="password" name="password" id="password" required>
            </div>
          </div>

          <div class="field">
              <label class="label" for="passwordRepeated">Password</label>
              <div class="control">
                <input class="input" name="passwordRepeated" id="passwordRepeated" required>
              </div>
          </div>

          <div class="field">
            <label class="label">Role</label>
            <div class="control">
              <div class="select">
                <select name="role" id="role" required>
                  <option <#if form.role == 'USER'>selected</#if>>USER</option>
                  <option <#if form.role == 'ADMIN'>selected</#if>>ADMIN</option>
                </select>
              </div>
            </div>
          </div>

          <div class="field is-grouped">
            <div class="control">
              <button class="button is-link" type="submit">Save</button>
            </div>
          </div>
      </form>

    </div>
  </div>
</section>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>


</body>
</html>