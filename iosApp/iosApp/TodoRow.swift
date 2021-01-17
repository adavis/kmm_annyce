//
//  TodoRow.swift
//  iosApp
//
//  Created by adavis on 1/11/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TodoRow: View {
    var todo: Todo
    
    var body: some View {
        HStack() {
            Toggle(todo.title, isOn: Binding.constant(todo.completed))
                .onTapGesture {
                    print("Tapped on the todo: \(todo.id)")
                }
        }
        .padding()
    }
}

struct TodoRow_Previews: PreviewProvider {
    static var previews: some View {
        TodoRow(todo: Todo(id: 1, title: "Test", completed: true))
    }
}
