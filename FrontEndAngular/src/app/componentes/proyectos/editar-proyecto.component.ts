import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Proyecto } from 'src/app/modelos/proyecto';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-editar-proyecto',
  templateUrl: './editar-proyecto.component.html',
  styleUrls: ['./editar-proyecto.component.css']
})
export class EditarProyectoComponent implements OnInit {

  proyecto: Proyecto = new Proyecto('', '', '', '', '');
  id: number = Number(this.activatedRoute.snapshot.paramMap.get('id'));

  constructor(
    private datosPorfolioServicio: DatosPorfolioService,
    private activatedRoute: ActivatedRoute,
    private toaster: ToastrService,
    private rutas: Router
  ) { }

  ngOnInit(): void {
    this.datosPorfolioServicio.verProyecto(this.id).subscribe(
      data => {
        this.proyecto = data;
        console.log(this.proyecto);
      },
      err => {
        this.toaster.error('Fallo al cargar la proyecto', 'Fail', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/proyectos']);
      }
    );
  }

  onUpdate(): void {
    this.datosPorfolioServicio.editarProyecto(this.id, this.proyecto).subscribe(
      data => {
        this.toaster.success('proyecto actualizado', 'OK', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['./proyectos']);
      },
      err => {
        this.toaster.error('Fallo al actualizar la proyecto', 'Fail', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/proyectos']);
      }
    )

  }
}
