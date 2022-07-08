import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Formacion } from 'src/app/modelos/formacion';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';
import { FormacionComponent } from './formacion.component';

@Component({
  selector: 'app-editar-formacion',
  templateUrl: './editar-formacion.component.html',
  styleUrls: ['./editar-formacion.component.css']
})
export class EditarFormacionComponent implements OnInit {

  formacion: Formacion = new Formacion('','','','');
  id: number = Number(this.activatedRoute.snapshot.paramMap.get('id'));

  constructor(
    private datosPorfolioServicio: DatosPorfolioService,
    private activatedRoute: ActivatedRoute,
    private toaster: ToastrService,
    private rutas: Router
  ) { }

  ngOnInit(): void {
    this.datosPorfolioServicio.verFormacion(this.id).subscribe(
      data => {
        this.formacion = data;
        //console.log(this.formacion);
      },
      err => {
        this.toaster.error('No se pueden encontrar los datos', 'Error', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/formacion']);
      }
    )
    
  }

  onUpdate(): void {
    this.datosPorfolioServicio.editarFormacion(this.id, this.formacion).subscribe(
      data => {
        this.toaster.success('Formacion actualizada', '', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['./formacion']);
      },
      err => {
        this.toaster.error('Fallo al actualizar la Formacion', 'Error', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/formacion']);
      }
    )
  }

}
