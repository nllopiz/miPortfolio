import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Habilidad } from 'src/app/modelos/habilidad';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-editar-habilidad',
  templateUrl: './editar-habilidad.component.html',
  styleUrls: ['./editar-habilidad.component.css']
})
export class EditarHabilidadComponent implements OnInit {

  habilidad: Habilidad = new Habilidad('','');
  id: number = Number(this.activatedRoute.snapshot.paramMap.get('id'));

  constructor(
    private datosPorfolioServicio: DatosPorfolioService,
    private activatedRoute: ActivatedRoute,
    private toaster: ToastrService,
    private rutas: Router
  ) { }

  ngOnInit(): void {
    this.datosPorfolioServicio.verHabilidad(this.id).subscribe(
      data => {
        this.habilidad = data;
        //console.log(this.habilidad);
      },
      err => {
        this.toaster.error('Fallo al cargar la habilidad', 'Fail', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/habilidad']);
      }
    )
  }

  onUpdate(): void { 
    this.datosPorfolioServicio.editarHabilidad(this.id, this.habilidad).subscribe(
      data => {
        this.toaster.success('Habilidad actualizada', 'OK', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['./habilidades']);
      },
      err => {
        this.toaster.error('Fallo al actualizar la habilidad', 'Fail', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/habilidades']);
      }
    )
  }

}
