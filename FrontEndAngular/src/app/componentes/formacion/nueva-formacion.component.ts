import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Formacion } from 'src/app/modelos/formacion';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-nueva-formacion',
  templateUrl: './nueva-formacion.component.html',
  styleUrls: ['./nueva-formacion.component.css']
})
export class NuevaFormacionComponent implements OnInit {

  titulo: string = '';
  periodo: string = '';
  pathLogo: string = '';
  descripcion: string = '';

  constructor(
    private datosPortfolioServicio: DatosPorfolioService,
    private toaster: ToastrService,
    private rutas: Router
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const formacion = new Formacion(this.titulo, this.periodo, this.pathLogo, this.descripcion);
    this.datosPortfolioServicio.nuevaFormacion(formacion).subscribe(
      data => {
        this.toaster.success('Formacion creada', '', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['./formacion']);
      },
      err => {
        this.toaster.error('Fallo al crear la Formacion', 'Error', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/formacion']);
      }
    )
  }

}
