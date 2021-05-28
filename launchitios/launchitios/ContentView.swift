import SwiftUI
import shared

struct ContentView: View {
    
    @ObservedObject var viewModel: MainViewModel
    
    var body: some View {
        List(viewModel.capsules, id: \.id) { capsule in
            VStack(alignment: .leading) {
                Text(capsule.type)
                    .font(.headline)
            }
        }.onAppear {
            viewModel.loadData()
        }
    }
}
