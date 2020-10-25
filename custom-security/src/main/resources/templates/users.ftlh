<#-- @ftlvariable name="users" type="java.util.List<com.hendisantika.example.domain.User>" -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.css" type="text/css">
        <meta charset="utf-8">
        <title>List of Users</title>
    </head>

    <body>

    <div class="field is-grouped">
      <p class="control">
         <a class="button is-link" href="/">Home</a>
      </p>
       <p class="control">
         <a class="button is-link" href="/user/create">Create a new user</a>
       </p>
    </div>

        <h1>List of Users</h1>

        <div class="table-container">
          <table class="table">
            <thead>
                <tr>
                    <th>E-mail</th>
                    <th>Role</th>
                </tr>
                </thead>
                <tbody>
                    <#list users as user>
                        <tr>
                            <td><a href="/user/${user.id}">${user.email}</a></td>
                            <td>${user.role}</td>
                        </tr>
                    </#list>
                </tbody>
          </table>
        </div>
    </body>
</html>