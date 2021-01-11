import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private var viewModel = ViewModel()
    
    var body: some View {
        NavigationView {
            listView()
                .navigationBarTitle("Todos")
                .navigationBarItems(trailing:
                                        Button("Reload") {self.viewModel.loadTodos(forceReload: true)})
        }
        .onAppear {
            viewModel.loadTodos(forceReload: false)
        }
    }
    
    private func listView() -> AnyView {
        switch viewModel.todos {
        case LoadableTodos.loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case LoadableTodos.result(let todos):
            return AnyView(List(todos) { todo in
                TodoRow(todo: todo)
            })
        case LoadableTodos.error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
}

extension Todo: Identifiable { }
