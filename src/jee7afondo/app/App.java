package jee7afondo.app;

import java.util.List;
import java.util.Scanner;

import jee7afondo.dto.CursoDTO;
import jee7afondo.dto.FormaPagoDTO;
import jee7afondo.dto.InscripcionDTO;
import jee7afondo.facade.Facade;

public class App {

	public static void main(String[] args) {

		Facade f = new Facade();

		_mostrarPantallaInsc(f);

		InscripcionDTO dto = _ingresoDatos();

		int idInsc = f.registrarInscripcion(dto);

		_mostrarPantallaConfirm(idInsc);

	}

	private static void _mostrarPantallaInsc(Facade f) {

		List<CursoDTO> cursos = f.obtenerCursos();

		List<FormaPagoDTO> formasPago = f.obtenerFormasPago();

		System.out.println("-- CURSOS --");

		for (CursoDTO dto : cursos) {
			System.out.println(dto.getIdCurso() + " - " + dto.getDescripcion());
		}

		System.out.println("-- FORMAS DE PAGO --");

		for (FormaPagoDTO dto : formasPago) {
			System.out.println(dto.getIdFormaPago() + " - " + dto.getDescripcion());
		}

	}

	private static InscripcionDTO _ingresoDatos() {

		String nombre;
		String telefono;
		int idCurso;
		int idFormaPago;

		Scanner sc = new Scanner(System.in);

		// ingreso nombre
		System.out.print("Ingrese su nombre: ");
		nombre = sc.next();

		// ingreso telefono
		System.out.print("Ingrese su telefono: ");
		telefono = sc.next();

		// ingreso ID de Curso
		System.out.print("Ingrese ID de Curso: ");
		idCurso = sc.nextInt();

		// ingreso ID de FormaPago
		System.out.print("Ingrese ID de Forma de Pago: ");
		idFormaPago = sc.nextInt();

		// cargo los datos ingresados al DTO
		InscripcionDTO dto = new InscripcionDTO();
		dto.setNombre(nombre);
		dto.setTelefono(telefono);
		dto.setIdCurso(idCurso);
		dto.setIdFormaPago(idFormaPago);

		// cierro
		sc.close();
		
		return dto;

	}

	private static void _mostrarPantallaConfirm(int idInsc) {

		System.out.println("Registro ingresado correctamente. ID Inscripción: " + idInsc);

	}

}
