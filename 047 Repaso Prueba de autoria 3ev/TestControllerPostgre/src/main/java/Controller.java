import model.dao.UsuarioDAO;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    // requ envio datos
    // resp recepcion datos

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Max-Age", "3600");

        PrintWriter out = response.getWriter();

        try {
            String action = request.getParameter("ACTION");
            System.out.println("🔍 ACTION recibido: " + action);

            if (action == null || !action.contains(".")) {
                out.print("{\"error\": \"Parámetro ACTION incorrecto o ausente (ej: USUARIO.LOGIN)\"}");
                return;
            }


            String[] arrayAction = action.split("\\.");
            String entidad = arrayAction[0];

            IAction actionHandler;

            switch (entidad) {
                case "USUARIO":
                    actionHandler = new UsuarioAction();
                    break;
                case "PRODUCTO":
                    actionHandler = new ProductoAction();
                    break;
                case "CARRITO":
                    actionHandler = new CarritoAction();
                    break;
                case "PEDIDO":
                    actionHandler = new PedidoAction();
                    break;
                case "CATEGORIA":
                    actionHandler = new CategoriaAction();
                    break;
                case "VALORACION":
                    actionHandler = new ValoracionAction();
                    break;
                case "INGREDIENTE":
                    actionHandler = new IngredienteAction();
                    break;
                case "ROL":
                    actionHandler = new RolAction();
                    break;
                case "USUARIO.CHANGE_PASSWORD":
                    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
                    String oldPass = request.getParameter("OLD_PASSWORD");
                    String newPass = request.getParameter("NEW_PASSWORD");

                    boolean exito = new UsuarioDAO("postgres").cambiarPasswordSeguro(idUsuario, oldPass, newPass);

                    out.print("{\"success\":" + exito + "}");
                    return; // ✅ muy importante para evitar error
                default:
                    out.print("{\"error\": \"Entidad no reconocida: " + entidad + "\"}");
                    return;
            }

            // ⚠️ SOLO imprimimos si hay algo que imprimir
            String resultado = actionHandler.execute(request, response);
            if (resultado != null) {
                out.print(resultado);
            }

        } catch (Exception e) {
            out.print("{\"error\": \"Error interno: " + e.getMessage() + "\"}");
        }
    }
}
