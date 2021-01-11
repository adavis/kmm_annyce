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
            Toggle(isOn: Binding.constant(todo.completed), label: { Text(todo.title).frame(maxWidth: .infinity, alignment: .leading) })
        }
        .padding()
    }
}

struct TodoRow_Previews: PreviewProvider {
    static var previews: some View {
        TodoRow(todo: Todo(id: 1, title: "Test", completed: true))
    }
}
