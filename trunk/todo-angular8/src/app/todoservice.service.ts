import {Injectable} from '@angular/core';
import {ToDo, serverPath} from '../utils/constants';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {retry, catchError} from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class TodoserviceService {
    apiURL = `${serverPath}/todo`;
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    }
    constructor(private http: HttpClient) {}
    /**
     * Todo : Get all ToDo items
     */
    getToDos(): Observable<ToDo[]> {
        return this.http.get<ToDo[]>(this.apiURL + '/getList')
            .pipe(
                retry(1),
                catchError(this.handleError)
            )
    }
    /**
     * Todo : Save ToDo item
     */
    saveToDo(toDo: ToDo): Observable<ToDo> {
        return this.http.post<ToDo>(this.apiURL + '/saveUpdate', toDo, this.httpOptions)
            .pipe(
                retry(1),
                catchError(this.handleError)
            )
    }
    /**
     * Todo : Delete ToDo item
     */
    deleteToDo(ids: number[]) {
        return this.http.post(this.apiURL + '/delete', ids, this.httpOptions)
            .pipe(
                retry(1),
                catchError(this.handleError)
            )
    }
    /**
     * Todo : For hamdle error from services
     */
    handleError(error) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
            // Get client-side error
            errorMessage = error.error.message;
        } else {
            // Get server-side error
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        window.alert(errorMessage);
        return throwError(errorMessage);
    }
}
