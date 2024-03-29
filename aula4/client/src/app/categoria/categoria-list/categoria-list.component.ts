import { Component, OnInit } from '@angular/core';
import { Categoria } from '../model/categoria';

import { CategoriaService } from '../service/categoria.service';

@Component({
  selector: 'app-categoria-list',
  templateUrl: './categoria-list.component.html',
  styleUrls: ['./categoria-list.component.scss']
})
export class CategoriaListComponent implements OnInit {

  categorias: Categoria[];

  constructor(private categoriaService: CategoriaService) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.categoriaService.findAll().subscribe(lista => {
      this.categorias = lista
    });
  }

  delete(id: number) {
    this.categoriaService.delete(id).subscribe(() => {
      this.findAll();
    });
  }

}
