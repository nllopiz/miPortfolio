import { Component, OnInit } from '@angular/core';
import { ChartData, ChartDataset, ChartOptions, ChartType } from 'chart.js';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';


@Component({
  selector: 'app-habilidades',
  templateUrl: './habilidades.component.html',
  styleUrls: ['./habilidades.component.css']
})
export class HabilidadesComponent implements OnInit {

  public misdatos: any;

  graficoChartOptions: ChartOptions = {responsive: true};
  graficoChartType: ChartType = 'doughnut';
  graficoChartDataSet: ChartDataset[] = [];
  graficoChartLabels: String[] = [];
  graficoChartBgColor: String[] = ['#E31B25', '#1C1C1C'];
  
  constructor(private datosPortfolio: DatosPorfolioService) {
    this.datosPortfolio.obtenerDatos().subscribe(data => {
      this.misdatos = data;
      console.log(this.misdatos.habilidades)
      for (const item of this.misdatos.habilidades) {
        this.graficoChartDataSet.push ({data: item.porcentajes});
        this.graficoChartLabels.push(item.nombre)
      }
      //console.log(this.graficoChartDataSet);
      //console.log(this.graficoChartLabels);
    });
   }

  ngOnInit(): void {
    
  }

  

  
}
