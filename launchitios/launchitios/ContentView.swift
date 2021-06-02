import SwiftUI
import shared

struct ContentView: View {
    
    @ObservedObject var viewModel: MainViewModel
    
    var body: some View {
        VStack {
            List(viewModel.capsules, id: \.id) { capsule in
                VStack(alignment: .leading) {
                    Text(capsule.type)
                        .font(.headline)
                }
            }
            List(viewModel.launches, id: \.id) { launch in
                VStack(alignment: .leading) {
                    Text(String(launch.isUpcoming))
                        .font(.headline)
                }
            }
        }.onAppear {
            viewModel.loadData()
        }
    }
}
