<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Number Converter</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1>The Number Converter</h1>
            <p>Enterprise Application Development (CO3409)</p> 
        </div>
        <div class="container">
            <form class="form-horizontal" name="convertion" action="Convertions" method="POST">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">User ID:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="userID" placeholder="User ID">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="email">Decimal:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="decimal" placeholder="Positive Number">
                    </div>
                </div>
                <div class="form-group">    
                    <label class="control-label col-sm-2" >Select Format: </label>
                    <div class="col-sm-10">
                        <select class="form-control" id="sel1" name="services">
                            <option value="binary">Binary</option>
                            <option value="hexa">Hexadecimal</option>
                        </select>
                    </div>
                </div>
                <div class="col-sm-offset-2 col-sm-10">        
                    <label class="radio-inline">
                        <input type="radio" name="radioFormat" value="XML">XML
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="radioFormat" value="JSON">JSON
                    </label>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary pull-right">Convert</button>
                    </div>
                </div>
            </form>

            <hr/>

            <div class="page-header">
                <h1>Show User Records</h1>
            </div>            
            <form class="form-horizontal" name="retrieve" action="RetrieveUsers" method="POST">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">User ID:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="report" placeholder="inser user ID">
                    </div>
                </div>
                <div class="form-group">    
                    <label class="control-label col-sm-2" >Select Format: </label>
                    <div class="col-sm-10">
                        <select class="form-control" id="sel1" name="format">
                            <option value="XML">XML</option>
                            <option value="JSON">JSON</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary pull-right">Show Records</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
