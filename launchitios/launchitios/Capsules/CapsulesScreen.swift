import SwiftUI
import shared

struct CapsulesScreen: View {
    
    @ObservedObject var viewModel: CapsulesViewModel
    
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
