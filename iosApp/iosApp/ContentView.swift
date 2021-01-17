import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private var viewModel = ViewModel(repository: TodosRepository())
    @State private var text = ""
    
    var body: some View {
        NavigationView {
            VStack {
                listView()
                    .navigationBarTitle("Todos")
                    .navigationBarItems(trailing:
                                        Button("Reload") {
                                            self.viewModel.loadTodos(forceReload: true)
                                        })
                HStack {
                    TextField("Enter your todo", text: $text)
                    Button("Submit") {
                        print("The new todo: \($text.wrappedValue)")
                        text = ""
                    }
                }.padding()
            }
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

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
