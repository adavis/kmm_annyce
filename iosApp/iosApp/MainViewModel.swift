//
//  MainViewModel.swift
//  iosApp
//
//  Created by adavis on 1/11/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class ViewModel: ObservableObject {
    let repository = TodosRepository(api: TodosApiReal())
    @Published var todos = LoadableTodos.loading
    
    func loadTodos(forceReload: Bool) {
        self.todos = LoadableTodos.loading
        repository.getAllTodos(forceReload: forceReload, completionHandler: { todos, error in
            if let todos = todos {
                self.todos = LoadableTodos.result(todos)
            } else {
                self.todos = LoadableTodos.error(error?.localizedDescription ?? "error")
            }
        })
    }
}
