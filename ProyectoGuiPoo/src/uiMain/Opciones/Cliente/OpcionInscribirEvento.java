package uiMain.Opciones.Cliente;

import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete2.Evento;
import java.util.ArrayList;
import java.util.Scanner;
import uiMain.menuConsola.OpcionDeMenu;
import static uiMain.menuConsola.MenuDeConsola.sesion;

public class OpcionInscribirEvento extends OpcionDeMenu {

    public OpcionInscribirEvento() {
        super("Inscribirse en un evento.");
    }

    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        Cliente cliente =((Cliente)sesion);
        ArrayList<Evento> Eventos = cliente.consultarEventos();
        ArrayList<Evento> Eventos1 = new ArrayList<>();
        ArrayList<Evento> EventosSinCupos = new ArrayList<>();
        if (Eventos == null || Eventos.isEmpty()) {
            System.out.println("Error, no se pudo realizar la acción.");
        } else {
            System.out.println("Eventos disponibles: ");
            int i = 0;
            for (Evento Evento : Eventos) {
                if (Evento.getInscritos() == Evento.getNumeroDeCupos()) {
                    EventosSinCupos.add(Evento);
                } else {
                    Eventos1.add(Evento);
                    System.out.println(i + ". Evento: " + Evento.getActividad() + ", horario: " + Evento.getHorario() + ", número de cupos : " + Evento.getNumeroDeCupos() + ", cupos disponibles : " + (Evento.getNumeroDeCupos() - Evento.getInscritos()) + ".");
                    i++;
                }

            }
            for (Evento Evento : EventosSinCupos) {
                System.out.println("Evento: " + Evento.getActividad() + ", horario: " + Evento.getHorario() + ", número de cupos: " + Evento.getNumeroDeCupos() + ", sin cupos disponibles.");

            }
            System.out.print("Digite el índice del evento al cuál desea inscribirse\n");
            int indice = Integer.parseInt(sc.nextLine());
            if (indice < Eventos1.size()) {
                Evento eventoElegido = Eventos1.get(indice);
                String actividadElegida = eventoElegido.getActividad();
                if (!cliente.agregarCliente(actividadElegida, sesion.getCedula(), sesion.getNombre())) {
                    System.out.println("Error, no se pudo realizar la acción.");
                } else {
                    System.out.println("Inscripción realizada.");
                }
            }
        }

    }
}
