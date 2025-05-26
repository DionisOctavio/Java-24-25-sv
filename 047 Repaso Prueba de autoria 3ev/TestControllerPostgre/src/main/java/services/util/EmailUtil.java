package services.util;

import model.entities.CarritoLista;

import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtil {


    // Cambia esto con tus datos
    private static final String REMITENTE = "outlawgrub@gmail.com";
    private static final String CONTRASENA = "dvba ukhb bojy sccn";
    private static final String HOST = "smtp.gmail.com";
    private static final int PUERTO = 587;

    public static void enviarCorreoConfirmacionPedidoCompleto(
            String destinatario, String nombreCliente, String direccion,
            List<CarritoLista> productos, BigDecimal total, int idPedido
    ) throws MessagingException {

        String codigoPedido = String.format("OW-%03d", idPedido);

        String tiempoEstimado = """
        Si has elegido envío a domicilio, tu pedido llegará en un plazo estimado de <strong>30-40 minutos</strong>.<br>
        Si has seleccionado recogida en tienda, <strong>puedes pasar a recogerlo en 15 minutos</strong> con el siguiente código de pedido: <strong>%s</strong>.
        """.formatted(codigoPedido);

        StringBuilder resumen = new StringBuilder();
        for (CarritoLista p : productos) {
            resumen.append("- ").append(p.getCantidad())
                    .append(" x ").append(p.getNombreProducto())
                    .append(" (").append(p.getPrecioProducto().setScale(2)).append(" €)<br>");
        }

        String cuerpoHtml = """
        <!DOCTYPE html>
        <html lang="es">
        <head><meta charset="UTF-8"></head>
        <body style="font-family: Arial; background:#f4f4f4; padding:2rem;">
            <div style="background:white; padding:2rem; border-radius:8px; max-width:600px; margin:auto;">
                <h2 style="color:#d35400;">¡Gracias por tu pedido, %s!</h2>
                <p>Hemos recibido tu pedido <strong>%s</strong>.</p>
                
                <h3>📦 Detalles del pedido:</h3>
                <p>%s</p>

                <h3>📍 Envío a:</h3>
                <p>%s</p>

                <h3>💰 Total:</h3>
                <p><strong>%.2f €</strong></p>

                <h3>⏱️ Tiempo estimado:</h3>
                <p>%s</p>

                <h3>ℹ️ Información importante:</h3>
                <ul>
                    <li>🍴 No incluye cubiertos.</li>
                    <li>⚠️ No se aceptan devoluciones de productos alimentarios.</li>
                    <li>📞 Si falta algún producto, contáctanos para darte una solución.</li>
                </ul>

                <p>Gracias por confiar en <strong>The Champion Burger</strong>.<br>Esperamos que disfrutes tu pedido 🍔</p>
                <p style="font-size:0.9rem; color:#888;">Este correo ha sido generado automáticamente. No respondas a esta dirección.</p>
            </div>
        </body>
        </html>
    """.formatted(nombreCliente, codigoPedido, resumen, direccion, total, tiempoEstimado);

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", String.valueOf(PUERTO));

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMITENTE, CONTRASENA);
            }
        });

        Message mensaje = new MimeMessage(session);
        mensaje.setFrom(new InternetAddress(REMITENTE));
        mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        mensaje.setSubject("✅ Confirmación de pedido " + codigoPedido);
        mensaje.setContent(cuerpoHtml, "text/html; charset=utf-8");

        Transport.send(mensaje);
    }





    public static void enviarCorreoConfirmacionRegistro(String destinatario) throws MessagingException {
        String asunto = "Bienvenido a Outlaw Grub";

        String cuerpoHtml = """
         <!DOCTYPE html>
                            <html lang="es">
                            <head>
                                <meta charset="UTF-8">
                            </head>
                            <body style="margin:0; padding:0; background-color:#ffffff; font-family: 'Segoe UI', sans-serif; color: #000000;">
                                <table width="100%" cellpadding="0" cellspacing="0" border="0" style="background-color: #ffffff;">
                                    <tr>
                                        <td >
                                            <table width="600" cellpadding="0" cellspacing="0" border="0" style="background-color:#ffffff; padding: 2rem; text-align: center;">
                                                <tr>
                                                    <td>
                                                        <img src="https://outlaw-grub.s3.us-east-1.amazonaws.com/IMG-LOGO/logo-full-b.png" alt="Outlaw Grub" width="180" style="margin-bottom: 1.5rem;">
                                                        <h2 style="margin: 0;">¡Bienvenido a Outlaw Grub!</h2>
                                                        <p style="margin-top: 0.5rem;">Tu cuenta ha sido creada con éxito.</p>
                                                        <hr style="margin: 2rem 0; border: none; border-top: 1px solid #ccc;">
                                                        <p style="text-align: left;">A partir de ahora podrás:</p>
                                                        <ul style="list-style: none; padding-left: 0; text-align: left;">
                                                            <li>🍔 Hacer pedidos online fácilmente</li>
                                                            <li>📍 Guardar direcciones favoritas</li>
                                                            <li>🧾 Consultar tu historial de pedidos</li>
                                                            <li>🎁 Acceder a ofertas y promociones exclusivas</li>
                                                        </ul>
                                                        <p style="margin-top: 2rem; text-align: left;">Nos alegra tenerte en nuestra comunidad. Si necesitas ayuda, contáctanos desde tu perfil.</p>
                
                                                        <p style="font-size: 0.85rem; color: #666666; margin-top: 2rem; text-align: center;">
                                                            Este correo ha sido enviado automáticamente. No respondas a esta dirección.<br />
                                                            &copy; Outlaw Grub — Todos los derechos reservados.
                                                        </p>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </body>
                            </html>
    """;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", String.valueOf(PUERTO));

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMITENTE, CONTRASENA);
            }
        });

        Message mensaje = new MimeMessage(session);
        mensaje.setFrom(new InternetAddress(REMITENTE));
        mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        mensaje.setSubject(asunto);
        mensaje.setContent(cuerpoHtml, "text/html; charset=utf-8");

        Transport.send(mensaje);
    }

    public static void enviarCorreoPremioCanjeado(String destinatario, String nombreCliente, String productoCanjeado, int puntosGastados) throws MessagingException {
        String asunto = "🎁 ¡Has canjeado un premio en Outlaw Grub!";

        String cuerpoHtml = """
    <!DOCTYPE html>
    <html lang="es">
    <head><meta charset="UTF-8"></head>
    <body style="font-family: Arial; background:#f4f4f4; padding:2rem;">
        <div style="background:white; padding:2rem; border-radius:8px; max-width:600px; margin:auto;">
            <h2 style="color:#27ae60;">¡Felicidades, %s!</h2>
            <p>Has canjeado exitosamente tu premio:</p>

            <h3>🎁 Producto:</h3>
            <p><strong>%s</strong></p>

            <h3>🔢 Puntos utilizados:</h3>
            <p><strong>%d pts</strong></p>

            <p>🎉 Disfruta tu recompensa y sigue acumulando puntos con cada compra.</p>

            <p style="margin-top: 1.5rem; font-weight: bold;">📍 Puedes canjear este premio en cualquiera de nuestras tiendas mostrando este email en caja.</p>

            <p>Gracias por formar parte de <strong>Outlaw Grub</strong>.</p>
            <p style="font-size:0.9rem; color:#888;">Este correo ha sido generado automáticamente. No respondas a esta dirección.</p>
        </div>
    </body>
    </html>
    """.formatted(nombreCliente, productoCanjeado, puntosGastados);

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", String.valueOf(PUERTO));

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMITENTE, CONTRASENA);
            }
        });

        Message mensaje = new MimeMessage(session);
        mensaje.setFrom(new InternetAddress(REMITENTE));
        mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        mensaje.setSubject(asunto);
        mensaje.setContent(cuerpoHtml, "text/html; charset=utf-8");

        Transport.send(mensaje);
    }


}
