import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Experiencia } from 'src/app/modelos/experiencia';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-editar-experiencia',
  templateUrl: './editar-experiencia.component.html',
  styleUrls: ['./editar-experiencia.component.css']
})
export class EditarExperienciaComponent implements OnInit {

  experiencia: Experiencia = new Experiencia('','','','');
  id: number = Number(this.activatedRoute.snapshot.paramMap.get('id'));
  
  constructor(
    private datosPorfolioServicio: DatosPorfolioService,
    private activatedRoute: ActivatedRoute,
    private toaster: ToastrService,
    private rutas: Router
  ) { }

  ngOnInit(): void {
    this.datosPorfolioServicio.verExperiencia(this.id).subscribe(
      data => {
        this.experiencia = data;
        //console.log(this.experiencia);
      },
      err => {
        this.toaster.error('Fallo al cargar la experiencia', 'Fail', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/experiencia']);
      }
    )
    
  }

  onUpdate(): void {
    this.datosPorfolioServicio.editarExperiencia(this.id, this.experiencia).subscribe(
      data => {
        this.toaster.success('Experiencia actualizada', 'OK', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['./experiencia']);
      },
      err => {
        this.toaster.error('Fallo al actualizar la experiencia', 'Fail', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/experiencia']);
      }
    )
  }


}
