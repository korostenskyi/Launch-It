import SwiftUI
import shared

struct ContentView: View {
    
    let greeting = Greeting()
    
    @State var posts = [Post]()
    
    var body: some View {
        List(posts, id: \.self) { post in
            VStack(alignment: .leading) {
                Text(post.title)
                    .font(.headline)
                Text(post.body)
                    .font(.subheadline)
            }
        }.onAppear {
            load()
        }
    }
    
    func load() {
        greeting.fetchPosts { result, error in
            if let result = result {
                print(result)
                posts.append(contentsOf: result)
            } else if let error = error {
                print(error)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
