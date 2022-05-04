<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserisci Contatto</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

  <script>
  $(document).ready(function(){
    var i=1;
    $('#add').click(function(){
      i++;
      $('#dynamic_email').append('<tr id="rowemail'+i+'">' +
              '<td style="width:12%">' +
              ' <input type="text" name="categoria_email[]" placeholder="Inseirisci Categoria" class="form-control name_list" value="Lavoro"/>' +
              '</td>' +
              '<td>' +
              ' <input type="text" name="email[]" placeholder="Inserisci Email" class="form-control name_list" />' +
              '</td>' +
              '<td>' +
              '<button type="button" name="remove" id="email'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');
    });
    var j=1;
    $('#add_telefono').click(function(){
      j++;
      $('#dynamic_telefono').append('<tr id="rowtel'+j+'">' +
              '<td style="width:12%">' +
              ' <input type="text" name="categoria_telefono[]" placeholder="Inseirisci Categoria" class="form-control name_list" value="Lavoro"/>' +
              '</td>' +
              '<td>' +
              ' <input type="text" name="telefono[]" placeholder="Inserisci Telefono" class="form-control name_list" />' +
              '</td>' +
              '<td>' +
              '<button type="button" name="remove" id="tel'+j+'" class="btn btn-danger btn_remove">X</button></td></tr>');
    });
    $(document).on('click', '.btn_remove', function(){
      var button_id = $(this).attr("id");
      $('#row'+button_id+'').remove();
    });

  });
</script>

</head>
<body>

  <div class="form-group" style="width: 70%">
    <form name="usrform" id="usrform" action="insert" method="POST">
      <label for="nome">Nome:</label><br>
      <input type="text" id="nome" name="nome" class="form-control name_list"><br>
      <label for="cognome">Cognome:</label><br>
      <input type="text" id="cognome" name="cognome" class="form-control name_list"><br>

      <div class="table-responsive">
        <label for="dynamic_email">Email:</label><br>
        <table class="table table-bordered" id="dynamic_email">
          <tr>
            <td style="width:12%">
              <input  type="text" name="categoria_email[]" placeholder="Inserisci Categoria" class="form-control name_list" value="Casa" />
            </td>
            <td>
              <input type="text" name="email[]" placeholder="Inserisci Email" class="form-control name_list" />
            </td>
            <td>
              <button type="button" name="add" id="add" class="btn btn-success">Aggiungi Email</button>
            </td>
          </tr>
        </table>
        <label for="dynamic_telefono">Telefono:</label><br>
        <table class="table table-bordered" id="dynamic_telefono">
          <tr>
            <td style="width:12%">
              <input  type="text" name="categoria_telefono[]" placeholder="Inserisci Categoria" class="form-control name_list" value="Casa" />
            </td>
            <td>
              <input type="text" name="telefono[]" placeholder="Inserisci Telefono" class="form-control name_list" />
            </td>
            <td>
              <button type="button" name="add" id="add_telefono" class="btn btn-success">Aggiungi Telefono</button>
            </td>
          </tr>
        </table>
        <label for="note">Note:</label><br>
        <textarea rows="4" cols="50" name="note" placeholder="Inserisci commento" id="note" form="usrform" class="form-control name_list"></textarea>
      </div>
      <input type="submit" name="submit" id="submit" class="btn btn-info" value="Inserisci" />
    </form>
  </div>
</body>
</html>
