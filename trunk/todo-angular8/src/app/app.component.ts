import {Component, ViewChild} from '@angular/core';
import {ToDo} from '../utils/constants';
import {AddTodoPopupComponent} from './add-todo-popup/add-todo-popup.component';
import {ConfirmPopupComponent} from './confirm-popup/confirm-popup.component';
import {ReadmorePopupComponent} from './readmore-popup/readmore-popup.component';
import {TodoserviceService} from './todoservice.service';
import {ToastrService} from 'ngx-toastr';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    @ViewChild(AddTodoPopupComponent, {static: true}) eventPopup: AddTodoPopupComponent;
    @ViewChild(ConfirmPopupComponent, {static: true}) confirmPopup: ConfirmPopupComponent;
    @ViewChild(ReadmorePopupComponent, {static: true}) readPopup: ReadmorePopupComponent;
    constructor(private todoserviceService: TodoserviceService, private toastr: ToastrService) {
    }
    isAllSelected: boolean;
    title = 'ToDoList';
    toDos: ToDo[] = [];
    selectedToDos: number[] = [];
    todo: ToDo;
    currentTime: number;
    ngOnInit() {
        this.getToDos();
    }

    /**
     * Todo: get All ToDo list
     */
    getToDos() {
        this.currentTime = new Date().getTime();
        this.todoserviceService.getToDos().subscribe(
            (x: ToDo[]) => {
                this.toDos = x;
            },
            err => console.error('Observer got an error: ' + err),
            () => console.log('Observer got a complete notification')
        );
    }
    
    /**
     * Todo: edit todo item
     */
    editTodo(todo: ToDo) {
        this.currentTime = new Date().getTime();
        if (todo.eventTimeMilis > this.currentTime) {
            todo.isRead = false;
            let todoStr = JSON.stringify(todo);
            this.eventPopup.callFromParent(JSON.parse(todoStr));
        } else {
            this.toastr.warning("Event Time is passed");
        }
    }

    /**
     * Todo: update Todo list on save or update
     */
    getToDosOnModify($event) {
        if ($event == true) {
            this.getToDos();
        }
    }
    
    /**
     * Todo: select/deselect single Todo item
     */
    selectTodo(todo: ToDo) {
        this.isAllSelected = false;
        if (todo.isChecked) {
            this.selectedToDos.push(todo.id);
        } else {
            const index: number = this.selectedToDos.indexOf(todo.id);
            if (index !== -1) {
                this.selectedToDos.splice(index, 1);
            }
        }
        if (this.selectedToDos.length == this.toDos.length) {
            this.isAllSelected = true;
        }
    }

    /**
     * Todo: select/deselect all Todo items
     */
    selectAll() {
        this.selectedToDos = [];
        if (this.isAllSelected) {
            this.isAllSelected = false;
            for (let i = 0; i < this.toDos.length; i++) {
                this.toDos[i].isChecked = false;
            }
        } else {
            this.isAllSelected = true;
            for (let i = 0; i < this.toDos.length; i++) {
                let todo = this.toDos[i];
                todo.isChecked = true;
                this.selectedToDos.push(todo.id);
            }
        }
    }

    /**
     * Todo: delete single ToDo item
     */
    deleteOne(id: number) {
        this.selectedToDos = [id];
        this.deleteAll();
    }

    /**
     * Todo: delete multiple Todo item
     */
    deleteAll() {
        if (this.selectedToDos.length > 0) {
            this.confirmPopup.openConfirmDialog("Are you sure want to delete?").then(
                (result) => {
                    this.todoserviceService.deleteToDo(this.selectedToDos).subscribe(
                        (x: any) => {
                            this.toastr.success(x.msg);
                            this.selectedToDos= [];
                            this.getToDos();
                        },
                        err => console.log(err)
                    );
                }, (reason) => {
                }
            );
        }
    }
}
