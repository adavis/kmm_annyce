import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    
    var body: some View {
        NavigationView {
            listView()
                .navigationBarTitle("Todos")
                .navigationBarItems(trailing:
                                        Button("Reload") {self.viewModel.loadTodos(forceReload: true)})
        }
    }
    
    private func listView() -> AnyView {
        switch viewModel.todos {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .result(let todos):
            return AnyView(List(todos) { todo in
                TodoRow(todo: todo)
            })
        case .error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
}

extension ContentView {
    enum LoadableTodos {
        case loading
        case result([Todo])
        case error(String)
    }
    
    class ViewModel: ObservableObject {
        let repository: TodosRepository
        @Published var todos = LoadableTodos.loading
        
        init(repository: TodosRepository) {
            self.repository = repository
            self.loadTodos(forceReload: false)
        }
        
        func loadTodos(forceReload: Bool) {
            self.todos = .loading
            repository.getAllTodos(forceReload: forceReload, completionHandler: { todos, error in
                if let todos = todos {
                    self.todos = .result(todos)
                } else {
                    self.todos = .error(error?.localizedDescription ?? "error")
                }
            })
        }
    }
}

extension Todo: Identifiable { }
