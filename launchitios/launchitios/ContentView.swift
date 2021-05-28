import SwiftUI
import shared

struct ContentView: View {
    
    @ObservedObject var viewModel: PostsViewModel
    
    var body: some View {
        List(viewModel.posts, id: \.self) { post in
            VStack(alignment: .leading) {
                Text(post.title)
                    .font(.headline)
                Text(post.body)
                    .font(.subheadline)
            }
        }.onAppear {
            viewModel.fetchData()
        }
    }
}
